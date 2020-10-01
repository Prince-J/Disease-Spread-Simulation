# Disease-Spread-Simulation
This was a program made using java code to simulate the spread of diseases between individuals. It was created with an algorithm using the ideas of random number sampling. 

## Table of contents
* [General info](#general-info)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Contact](#contact)

## General info
### Implementation of simulation

It was implemented through random number generation and the use of the State design pattern. The “Individual” object - representing a person - was the key to the simulation. 

"Individual" has 5 variables:
* Position in the environment
* Movement direction
* Health value 
* Current state
* How long they have had the infection

"Individual" can have four different states:
* Healthy -  has not been affected by the disease yet. Health value may increase or decrease slightly daily. Can transition to 'Infected' state through contact with infected individual.
* Infected - Currently experiencing the effects of the disease. Health Value decreases daily. Can transition to 'Recovered' or 'Dead' state.
* Recovered - Survived after experiencing the effects of the disease.
* Dead - Did not survive after experiencing the effects of the disease.

### Running the Program
When ran, the program generates an environment for the individuals to be put in. The individuals are then placed on random spots in the environment and given a random direction to travel. A random amount of the individuals are set to be infected, then the individuals begin to interact, moving and changing states for a set amount of days.

## Setup
To run this project, open the files in a java compiler and run the 'Simulation.java' file.

## Features
List of features ready and TODOs for future development
* Statistics
* Displays average amount of daily infected

To-do list:
* Add a GUI to make it easier to run

## Status
Project is: _in progress_

There are more things i plan to change and implement such as the graphical interface.

I have also been considering:
* Switching it to a python program
* Moving more towards an Agent Based Modeling implementation

## Contact
Email: obohprincejohn@gmail.com
