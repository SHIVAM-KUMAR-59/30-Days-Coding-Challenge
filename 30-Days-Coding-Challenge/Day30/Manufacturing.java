
// A manufacturing company has a production line with several workstations processing batches of raw materials. Each workstation operates in discrete time steps, processing, remaining idle, or passing batches to the next workstation. Workstations have limited capacities and aim to optimize throughput while minimizing downtime and bottlenecks.

// Requirements:

// 1. Track workstation status (processing, idle, passing) at each time step.

// 2. Manage dynamic changes: add/remove workstations, change capacities, vary batch arrival rates.

// 3. Simulate the production line over a specified period, providing statistics on throughput, idle time, and bottlenecks.

import java.util.*;

public class Manufacturing {

    class Batch {
        private int id;
        private int processingTime;

        public Batch(int id, int processingTime) {
            this.id = id;
            this.processingTime = processingTime;
        }

        public int getId() {
            return id;
        }

        public int getProcessingTime() {
            return processingTime;
        }

        public void decreaseProcessingTime() {
            processingTime--;
        }
    }

    enum WorkstationStatus {
        PROCESSING, IDLE, PASSING
    }

    class Workstation {
        private int id;
        private int capacity;
        private Queue<Batch> queue;
        private WorkstationStatus status;
        private int idleTime;
        private int processedBatches;

        public Workstation(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;
            this.queue = new LinkedList<>();
            this.status = WorkstationStatus.IDLE;
            this.idleTime = 0;
            this.processedBatches = 0;
        }

        public boolean canAcceptBatch() {
            return queue.size() < capacity;
        }

        public void addBatch(Batch batch) {
            if (canAcceptBatch()) {
                queue.add(batch);
            }
        }

        public void process() {
            if (!queue.isEmpty()) {
                Batch currentBatch = queue.peek();
                currentBatch.decreaseProcessingTime();
                if (currentBatch.getProcessingTime() == 0) {
                    queue.poll();
                    processedBatches++;
                    status = WorkstationStatus.PASSING;
                } else {
                    status = WorkstationStatus.PROCESSING;
                }
            } else {
                status = WorkstationStatus.IDLE;
                idleTime++;
            }
        }

        public WorkstationStatus getStatus() {
            return status;
        }

        public int getIdleTime() {
            return idleTime;
        }

        public int getProcessedBatches() {
            return processedBatches;
        }

        public Batch getCompletedBatch() {
            return (status == WorkstationStatus.PASSING) ? queue.poll() : null;
        }
    }

    class ProductionLine {
        private List<Workstation> workstations;
        private int totalTimeSteps;
        private int currentTimeStep;
        private Random random;

        public ProductionLine(int initialWorkstations, int capacity) {
            this.workstations = new ArrayList<>();
            for (int i = 0; i < initialWorkstations; i++) {
                workstations.add(new Workstation(i, capacity));
            }
            this.random = new Random();
            this.currentTimeStep = 0;
        }

        public void addWorkstation(int capacity) {
            workstations.add(new Workstation(workstations.size(), capacity));
        }

        public void removeWorkstation(int index) {
            if (index >= 0 && index < workstations.size()) {
                workstations.remove(index);
            }
        }

        public void changeWorkstationCapacity(int index, int newCapacity) {
            if (index >= 0 && index < workstations.size()) {
                Workstation newStation = new Workstation(index, newCapacity);
                workstations.set(index, newStation);
            }
        }

        public void simulate(int timeSteps) {
            this.totalTimeSteps = timeSteps;
            for (currentTimeStep = 0; currentTimeStep < timeSteps; currentTimeStep++) {
                processTimeStep();
            }
        }

        private void processTimeStep() {
            // Generate new batch with random probability
            if (random.nextDouble() < 0.7) { // 70% chance of new batch arriving
                Batch newBatch = new Batch(currentTimeStep, random.nextInt(5) + 1);
                if (workstations.get(0).canAcceptBatch()) {
                    workstations.get(0).addBatch(newBatch);
                }
            }

            // Process each workstation
            for (int i = workstations.size() - 1; i >= 0; i--) {
                Workstation current = workstations.get(i);
                current.process();

                if (current.getStatus() == WorkstationStatus.PASSING && i < workstations.size() - 1) {
                    Batch completedBatch = current.getCompletedBatch();
                    if (completedBatch != null && workstations.get(i + 1).canAcceptBatch()) {
                        workstations.get(i + 1).addBatch(completedBatch);
                    }
                }
            }
        }

        public void printStatistics() {
            System.out.println("Simulation completed for " + totalTimeSteps + " time steps.");
            for (int i = 0; i < workstations.size(); i++) {
                Workstation station = workstations.get(i);
                System.out.println("Workstation " + i + ":");
                System.out.println("  Processed batches: " + station.getProcessedBatches());
                System.out.println("  Idle time: " + station.getIdleTime());
                double utilizationRate = 1 - (double) station.getIdleTime() / totalTimeSteps;
                System.out.println("  Utilization rate: " + String.format("%.2f", utilizationRate));
            }

            int bottleneckIndex = 0;
            int minProcessed = Integer.MAX_VALUE;
            for (int i = 0; i < workstations.size(); i++) {
                if (workstations.get(i).getProcessedBatches() < minProcessed) {
                    minProcessed = workstations.get(i).getProcessedBatches();
                    bottleneckIndex = i;
                }
            }
            System.out.println("Bottleneck identified at Workstation " + bottleneckIndex);
        }
    }

    public class ProductionLineSimulation {
        public static void main(String[] args) {
            ProductionLine line = new ProductionLine(5, 3);
            line.simulate(1000);
            line.printStatistics();

            // Demonstrating dynamic changes
            line.addWorkstation(2);
            line.removeWorkstation(2);
            line.changeWorkstationCapacity(1, 4);

            line.simulate(1000);
            line.printStatistics();
        }
    }
}
