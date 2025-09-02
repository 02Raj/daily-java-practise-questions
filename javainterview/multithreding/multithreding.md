multithreading
│── ThreadCreation
│    ├── MyThreadExtends.java      # Thread class ko extend karke thread banana
│    ├── MyRunnableImpl.java       # Runnable interface implement karke thread banana
│    └── ThreadCreationDemo.java   # In dono ka demo run karna
│
│── ThreadLifecycle
│    └── ThreadStatesDemo.java     # Thread states: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
│
│── Synchronization
│    ├── SyncMethodDemo.java       # Synchronized method example
│    ├── SyncBlockDemo.java        # Synchronized block example
│    ├── DeadlockDemo.java         # Deadlock problem demo
│    └── AvoidDeadlockDemo.java    # Deadlock se bachne ka example
│
│── ConcurrencyUtilities
│    ├── ExecutorServiceDemo.java  # ExecutorService, ThreadPool usage
│    ├── CallableFutureDemo.java   # Callable + Future usage
│    ├── CountDownLatchDemo.java   # CountDownLatch example
│    ├── CyclicBarrierDemo.java    # CyclicBarrier example
│    ├── SemaphoreDemo.java        # Semaphore usage
│    └── ConcurrentCollections.java# ConcurrentHashMap, CopyOnWriteArrayList
│
│── InterThreadCommunication
│    ├── WaitNotifyDemo.java       # wait(), notify(), notifyAll() usage
│    └── ProducerConsumerDemo.java # Producer-Consumer problem solution
│
│── Atomic
│    └── AtomicVariableDemo.java   # AtomicInteger, AtomicBoolean usage
│
│── Volatile
│    └── VolatileDemo.java         # volatile keyword demo
│
│── ThreadLocal
│    └── ThreadLocalDemo.java      # ThreadLocal usage


multithreading/
│── README.md
│── basics/
│   │── ThreadCreation.java
│   │── RunnableExample.java
│   │── ThreadMethods.java
│
│── synchronization/
│   │── SyncBlockExample.java
│   │── SyncMethodExample.java
│   │── DeadlockExample.java
│
│── concurrency/
│   │── ExecutorServiceExample.java
│   │── CallableFutureExample.java
│   │── ScheduledExecutorExample.java
│
│── advanced/
│   │── ProducerConsumerWaitNotify.java
│   │── ProducerConsumerBlockingQueue.java
│   │── CountDownLatchExample.java
│   │── CyclicBarrierExample.java
│   │── SemaphoreExample.java
│   │── PhaserExample.java
