# Java Animator 2018
Course project for Object Oriented Design at Northeastern University. The purpose of the project was to introduce students to a larger codebase using the MVC pattern. Other design patterns such as Factory, Builder, Adapter, etc. were used at the discretion of the students based on what we learned in lecture. 

# Warning to Current Students
This repo is currently public while I job hunt.\
If you're looking to use this repo to 'help' you with your assignments in OOD, please don't :). \
It won't help you in the long run. Go to office hours.
# Getting Started

## Prequisites
- Familiarity with the command line
- Git to clone the repository
  - Follow this link for detailed instructions on dowloading Git for your operating system: [How to Install Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
  
## Installing
Use the following command to clone the repository
```
git clone https://github.com/wakira765/java-animator.git
```
If you're not using Git, you could directly download a zip file of the repository and unpack it.

# Running the Animator
Change your working directory to the resources directory in the copied repository.\
In the resources directory is the jar file we'll be using to run the program. 

## Commands
```
useage: java -jar java-animator.jar [options]
```
Optional Commands:
- `-in <file-name>`
  - Choose any text file from the resources folder
  - By default the animator will run the smalldemo.txt file
- `-view <view-name>`
  - `visual`
    - Displays the animation in a new Swing window
    - By default the animator will run a visual animation
  - `text`
    - Generates a text based description of the animation to the console
  - `svg`
    - Generates a SVG based description of the animation to the console
  - `edit`
    - Displays the animation in a new Swing window with an interface to edit the animation
  - `provider`
    - Same as edit, but uses a different team's editting View
- `-speed <number-value>`
  - Choose a speed to start the program with
  - The default speed for the program is 30
  - This command is irrelevant for the text and svg views
- `-dest <file-name>`
  - Can direct the output of the text and svg view to a specified file
  - Irrelvant for the visual, edit and provider views

## Examples
Running defaults:
```
C:~\java_animator_2018\resources> java -jar java-animator.jar
```
Running hanoi.txt with the svg view:
```
C:~\java_animator_2018\resources> java -jar java-animator.jar -in hanoi.txt -view svg
```
Running buildings.txt:
```
C:~\java_animator_2018\resources> java -jar java-animator.jar -in buildings.txt
```
Running big-bang-big-crunch.txt with the edit view:
```
C:~\java_animator_2018\resources> java -jar java-animator.jar -in big-bang-big-crunch.txt -view edit
```



# Authors
Akira Watanabe and Yasmin Zhamborova

# Acknowledgements
- The code in animator.util was provided by the instructors of the course, Amit Shesh and Ben Lerner.
- Other than that the code used in this project is the work of the authors. 

