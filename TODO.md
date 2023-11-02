# Responsibility of the Actors

- DependencyMiner: Generate the candidates (Each column with each column)
- DependencyWorker: Validate the candidates (Easiest solution: columnA.containsAll(columnB))
- InputReader: Reads the input file in batches
- InputCollector (?): Collects all the batches and notifies the DependencyMiner once ready?
- ResultCollector: Collects the results