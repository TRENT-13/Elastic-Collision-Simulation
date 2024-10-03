# Kd-Tree Range Search and Nearest Neighbor Visualization

This project implements a data structure for performing range searches and nearest neighbor searches using a Kd-Tree. It provides visualization tools to demonstrate the efficiency and correctness of the algorithm, as well as an input simulation of a Brownian motion experiment inspired by Einstein's observations of particles under random motion.

## Project Description

The goal of this project is to implement and visualize the Kd-Tree, a data structure used to efficiently organize points in a two-dimensional plane. The implementation includes the following components:

1. **PointSET.java**: This class provides a simple brute-force implementation of storing a set of points, allowing for operations like range search and nearest neighbor query using a 2D tree data structure. This is used as a baseline comparison for the Kd-Tree.

2. **RangeSearchVisualizer.java**: A tool for visualizing the range search operations using the Kd-Tree. This class shows how efficiently the Kd-Tree can find all points within a given rectangular region compared to a brute-force approach.

3. **NearestNeighborVisualizer.java**: A visualization utility for finding the nearest neighbor to a given query point. This class demonstrates how the Kd-Tree efficiently reduces the number of points that need to be examined when compared to a straightforward search.

4. **Brownian Motion Input File**: This project also includes an input file that simulates a Brownian motion experiment. The experiment is based on Einstein's observation of photons and particles undergoing random motion, providing a dataset for testing the efficiency of range and nearest neighbor searches. Brownian motion is the random motion of particles suspended in a fluid, a phenomenon that Einstein studied to understand the nature of light and atomic behavior.

## Features

- **Efficient Range Search**: Use of Kd-Tree to quickly find all points that lie within a given rectangular region.
- **Nearest Neighbor Search**: Fast query to find the closest point to a given target, leveraging the properties of Kd-Tree to reduce search time.
- **Visualization Tools**: `RangeSearchVisualizer` and `NearestNeighborVisualizer` provide an intuitive way to understand the performance and behavior of the Kd-Tree compared to brute-force methods.
- **Brownian Motion Simulation**: The input dataset of points follows a Brownian motion pattern, simulating the movement of particles as observed in Einstein's experiment.

## Project Structure

. ├── PointSET.java ├── RangeSearchVisualizer.java ├── NearestNeighborVisualizer.java └── data/ └── brownian_motion_input.txt


- **PointSET.java**: A class implementing point storage and operations using a basic brute-force method.
- **RangeSearchVisualizer.java**: A class used to visualize range queries on both `PointSET` and Kd-Tree.
- **NearestNeighborVisualizer.java**: A class used to visualize nearest neighbor queries on both `PointSET` and Kd-Tree.
- **data/brownian_motion_input.txt**: Input file containing data points generated using Brownian motion, used to simulate the experiment conducted by Einstein.

## How to Run

1. Compile the Java files using:
   ```sh
   javac PointSET.java RangeSearchVisualizer.java NearestNeighborVisualizer.java
Run the visualizers:

For range search visualization:
sh
Copy code
java RangeSearchVisualizer
For nearest neighbor visualization:
sh
Copy code
java NearestNeighborVisualizer
The visualizers will read the data from data/brownian_motion_input.txt to create the point set, which follows a Brownian motion pattern.

Einstein's Brownian Motion Experiment
The input dataset simulates a Brownian motion experiment, where particles undergo a random motion, a phenomenon that was critical in confirming the existence of atoms. Einstein's theoretical work on Brownian motion provided evidence for atomic theory by predicting how particles move when subjected to collisions with surrounding atoms.

In this project, the dataset is used to benchmark and test the efficiency of the implemented Kd-Tree against the brute-force method provided by PointSET.java.

Requirements
Java JDK 8 or higher
A visual display (Java GUI libraries are used for visualization)
License
This project is licensed under the MIT License. See the LICENSE file for more details.

Acknowledgments
Albert Einstein's contributions to the theory of Brownian motion, which laid the groundwork for statistical physics.
The concept of Kd-Trees as introduced by Jon Bentley in 1975 for efficiently partitioning space for search queries.
