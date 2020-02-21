# Drawscillate

[User Story Video](https://youtu.be/8FFxvjQ4u8Q)

## Topic

Drawscillate: An interactive audio-visual game.

## Team 

* [Aditya Agrawal](https://github.com/agrawaladit)
* [Andrew Selvia](https://github.com/AndrewSelvia)
* [Hetal Shah](https://github.com/ihetal)
* [Rajeev Sebastian](https://github.com/RajeevSebastian)
* [Shraddha Nayak](https://github.com/shraddhanayak07)

## Summary

Drawscillate enables you to play with sound & color to express your creativity. Harking back to the classic Buzz Wire game, this modern interpretation demands your focus as you attempt to trace a simple shape (like a heart or a star). Along the way, use the keyboard to switch colors and play with the oscillating sounds that react to your movements. However you choose to play, we sincerely hope you have fun!

## Architecture Diagram

![Architecture Diagram](images/ArchitectureDiagram.png)

Drawscillate is built on the JDK 8 & Java 8 platform. It is built using Gradle 4.9. The libraries used include:
* processing.core: Enables presentation of basic GUI elements & mouse interactions
* processing.sound, com.jsyn, fr.delthas.javamp3: Enables the playback of the oscillating sounds from which Drawscillate derives its name

## Key Features

* Choose from 4 shapes: Star, Rectangle, Heart, Circle
* Choose from 3 difficulties: Easy, Normal, Hard
* Draw a line with your mouse
* Switch between 7 different colors while drawing: Black, Blue, Green, Orange, Purple, Red, Yellow
* Alter the oscillation of a background sound as you draw
* Trace within the boundaries of the shape from start to finish to win the game
* Share your finished artwork with the auto-generated picture of your completed drawing

## Contributions

### [Aditya Agrawal](https://github.com/agrawaladit)

#### Features to make game look alive

As a game enthusiast and more importantly a member of Drawscillate, came up with small features which would make the player connect with Drawscillate more. I integrated features like:
* [Enter your name](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/68)
* [Replay button](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/82)
* [Dropdown for shape and difficulty selection](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/53)

I used the *Singleton* pattern to display player name onto various screens and the *Observer* pattern for the replay button.

#### Score Evaluation

[Score evaluation](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/92) is a vital part of the game. Without it, the user won't play a game repetitively. The *Strategy* pattern was used for calculation of score. With change in shapes and difficulties, changes strategy!

#### Save Image if you win the game

In the era of social media, it's almost impossible people would not like to boast about their victories. We [save images](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/81) to players' local directories so they can share any time. Be it sharing with their friends or collecting it as a souvenir, we have everything sorted out.

#### UML Diagrams

I worked on Use Case Diagram, Class Diagram for Strategy Pattern and Sequence Diagram of a player winning a game.

Lastly, Drawscillate was not done by any one individual; every member's contributions made it happen.

### [Andrew Selvia](https://github.com/AndrewSelvia)

#### Idea Generation

I experimented with various game ideas (Pac-Man, Sudoku, etc.) and tools (Greenfoot, Processing, etc.) until I found something original and achievable within a two-week time frame. Then, I created our *Product Backlog* on GitHub with dozens of issues which allowed us to plan our sprints, target key features, and plan for design patterns such as *State*, *Observer*, and *Command*.

#### Scrum Master

One of the primary responsibilities of a scrum master is to remove impediments. The following contributions exemplify how I scouted ahead for our team to enable us to move with as much velocity as possible:
* Demonstrated the core [drawing](https://github.com/nguyensjsu/fa19-202-drawscillate/commit/3eeb721596dcbf29653d4d1ae4e11bc2eccf41fc) & [sound](https://github.com/nguyensjsu/fa19-202-drawscillate/commit/bed4f86bafa857d8a4e6261b7c5beb36b1bdceb9) APIs we would use to assemble our game
* Enabled us to [develop in IDEs other than Processing](https://github.com/nguyensjsu/fa19-202-drawscillate/commit/6b66e65cec595e057bc1e2d2cd49e947969db246) (i.e. Eclipse, IntelliJ IDEA), thereby leveraging skills we have built up in those environments and avoid the awkward ramifications of using Processing (i.e. .pde files rather than plain Java)
* Observed during our daily stand up meetings during Sprint 2 that we were all approaching a bottleneck of bad design (Drawscillate.java was a god class), so I bit the bullet to [deliver a well-designed refactoring into multiple screens](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/62) so the team could keep making progress over the remaining few days of the sprint. This work required implementing the *Observer* pattern.
* Added a [CI/CD pipeline with *spotbugs* & *smartsmells*](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/97) to provide us insights into our code's quality during development

In addition, I coordinated daily stand up meetings, retrospectives, and contributed significantly to our [User Story Video](https://youtu.be/8FFxvjQ4u8Q).

### [Hetal Shah](https://github.com/ihetal)

As a member of Drawscillate, I worked rigorously on refactoring so that the code continues to be maintainable. In this process I tried to remove redundancies, eliminate unused features, and rejuvenate obsolete designs. The following contributions exemplifies this:
* [Refactoring App Controller]( https://github.com/nguyensjsu/fa19-202-drawscillate/pull/48)
* [Refactoring Options Screen]( https://github.com/nguyensjsu/fa19-202-drawscillate/pull/88)
* [Refactoring Game Screen]( https://github.com/nguyensjsu/fa19-202-drawscillate/pull/80)
* [Refactoring Game Logic]( https://github.com/nguyensjsu/fa19-202-drawscillate/pull/110)

I also added and formatted the UI on the [options screen](https://github.com/nguyensjsu/fa19-202-drawscillate/pull/76) to make the game feel more complete.

Along with refactoring, I also implemented the following design patterns: Singleton, Observer, Composite.

### [Rajeev Sebastian](https://github.com/RajeevSebastian)
As a member of the drawscillate team I worked on the logic for game completion and the ability for the user to go back to the main screen
#### Game completion logic

I implemented the logic by which we could identify when the player has successfully completed the game.It was done by creating checkpoints on the screen which the user had to traverse.

#### Design Patterns

I implemented the state pattern to keep a record of where the user is currently while playing the game
#### Quality

I worked extensively on reducing the code smells in the project and improving the overall code quality

### [Shraddha Nayak](https://github.com/shraddhanayak07)

As a member of Drawscillate, I focused on staying productive and completing all features of this game as planned. I came up with a few creative details that we added into the game to make it more interesting.

#### Design Patterns

I spent a lot of time in reading about design patterns that we could not implement before in our labs and picked up two patterns
* [Factory Method](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/64)
* [Memento](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/75)

These design patterns fit elegantly into our game scenario. The implementation of these patterns and drawing class diagrams for them helped me and my teammates to learn and study about more design patterns.

#### Add custom cursor

I took initiative in adding [custom cursors](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/30) when the user changes color. This imbues the game with a sense of playfulness that players of all ages will appreciate. This was implemented using the *Command* pattern.

#### Added Shapes

This project helped me to learn processing in depth. Using its functions and tools helped me in creating [Star, Circle and Rectangle shapes](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/1).

#### Created Activity Diagram

I also worked on implementing activity diagram that could summarize the overall flow of our game.

## Design & Documentation

### Choosing Shapes

Drawscillate enables you to choose between four different shapes to trace. Since `ShapeFactory` "can't anticipate the class of [shape] it must create", we chose to use the Factory Method design pattern for this feature. Each of `Heart`, `Star`, `Circle`, and `Rectangle` implement the `IShapes` interface. `GameScreen` has a `shapeFactory` that knows how to get the desired shape.

![Factory Method](images/FactoryMethod.png)

### Changing Drawing Color

We wanted to build in the ability to change the color of your line while you are in the act of drawing; it seemed fun. A solution presented itself to us: select the key for the first letter of the primary color you want. Additional brainstorming led us to imagine the user being able to remap the colors to different keys based on their preferences. Additionally, we would like to eventually support replaying a drawing; in which case, we would need to have a log of when each color was pressed. This immediately began to sound like the *Command* pattern.

> Command decouples the object that invokes the operation from the one that knows how to perform it.

> Support logging changes so that they can be reapplied in case of a system crash

In the diagram below, we highlight how the `IColorCommand` interface abstracts away the implementation from the `IColorInvoker`. We think this architecture would allow us to support such advanced features in future sprints. 

![Command](images/CommandPattern-ChangeColor.png)

### Activity Diagram

The activity diagram below depicts the basic flow a user follows in order to play the game. Complete with screenshots from each screen, it connects actions such as *entering a username*, *selecting a shape*, and *drawing completion* to their respective behaviors within the game.

![Activity Diagram](images/ActivityDiagram.png)

### Use Case Diagram

The player's potential actions, including variability, are depicted in the use case diagram below.

![Use Case Diagram](images/UseCaseDiagram.jpg)

### Sequence Diagram

Here, we show the methods called during a normal play session. Take note of the following details:
* 1: `AppController` is a *Singleton*
* 2: `AppController` utilizes the *Observer* pattern to react when the user proceeds from the `WelcomeScreen`
* 5: This demonstrates how a `Button` only triggers notifications to its observers when you release the mouse; we had to fix a bug earlier where `Button`s were errantly activated during the `mousePressed` event
* 16: The game logic which determines if the user has entered the win or lose state is summarized

![Sequence Diagram](images/SequenceDiagramDrawscillate.jpg)

### State Diagram

Starting from the start state, this state diagram depicts how your mouse movements (staying within vs. exiting the shape boundary) impact which of the two end states you enter. If you've stayed within the boundaries *and* crossed all check points, then you win! Early on, we realized that we would have to design a solution for determining if the user actually completed the shape. In our first prototype, you could simply draw forward then go back to the starting point to "win". Our solution is to accumulate check points as you draw to determine if you should win.

![State Diagram](images/GameLogicStateDiagram.JPG)

### Game Logic Class Diagram

The state pattern was employed to represent in which state the game currently resided. The sequence diagram above depicts the transitions more clearly, but this diagram shows how the states fit in to the `GamePlayStateMachine` which manages those transitions and notifies its *Observer*s about state transitions.

![Game Logic Class Diagram](images/GameLogicClassDiagram.JPG)

### Memento Class Diagram

One of our goals was to track the user's mouse movements so we could potentially restore the state. For instance, if the user wants to take a break in between the game, the memento pattern stores the state of diagram so that user can resume from where they had left. Shraddha imagined this would be a good use case for the *Memento* pattern. As stated in *Design Patterns*:

> Use the Memento pattern when a snapshot of (some portion of) an object's state must be saved so that it can be restored to that state later

![Memento Class Diagram](images/Memento.png)

### Score Strategy Class Diagram

Aditya set out to build us a scoring feature. During this work, he encountered a need for the strategy pattern to account for the variability in shape & difficulty. Each shape has its own scoring strategy to ensure that we fairly evaluate each use case.

![Score Strategy Class Diagram](images/ClassDiagramScoreStrategy.jpg)

## Scrum

[Sprint Task Sheet](https://docs.google.com/spreadsheets/d/1EVMsOQ3g3JuIVDFdPkGSJBxW_JH25RkZzY6yD2SRak4)

### Sprints

We broke the project in to two one-week sprints so that we could at least make process improvements once during the project.

#### Sprint 1: 11/9-11/15

Our sprint goal was to attack the core problems, allowing ourselves leniency on quality temporarily. We aimed to have a proof-of-concept version of the game working as a deliverable. Each member pulled from the Sprint Backlog to assemble a list of achievable tasks. We did rough estimation, but found it difficult since everyone was very new to Processing. By the end of the sprint, we had a working prototype that we were able to include in our User Story Video.

A major process improvement opportunity we highlighted during our retrospective was to do a better job of accounting for dependencies during estimation. This arose because Rajeev volunteered for [a task](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/5) which depended entirely on multiple other tasks. By the time they were finished, he only had a day or two left in the sprint and he was unable to hit the deadline. This was ultimately a result of poor planning. 

Another process issue we identified was that we were recording our effort incorrectly. Rather than subtracting the number of hours we worked on a task, so that the task *burned down*, we accumulated hours worked on a task. This made our burndown chart look like a saw blade rather than a decreasing incline. 

![Sprint 1 Burndown Chart](images/Sprint1BurndownChart.png)

[Sprint 1 Retrospective Video](https://youtu.be/xQuffx0hzCM)

#### Sprint 2: 11/16-11/22

Learning from Sprint 1, we threw out some tasks: ([#9](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/9), [#10](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/10), [#12](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/12)) we had planned to take on during Sprint 2 due to dependencies they had on other parts of the project. This focus allowed us to deliver on our core mission and maintain a stable backlog. We had one task ([#45](https://github.com/nguyensjsu/fa19-202-drawscillate/issues/45)) which we underestimated severely. It grew due to an accumulation of technical debt in the form of a god class. By the time we resolved to fix it, the task was large. In hindsight, we can see that we should have prioritized that work earlier to save us headaches down the road.

We also were intentional about having our daily standups at 10pm over Google Hangouts. The first sprint was a mixed bag of WhatsApp/Slack group messages that didn't achieve great participation. By sprint 2, we had hit our stride and resolved technical difficulties. Each stand up meeting lasted roughly 30 minutes. You can review a few of them below which we have uploaded to YouTube.

During our second retrospective, we highlighted our improvement at the planning stage that led to us completely burning down our tasks. We also are proud that we were able to include codesmells & spotbugs into the project via a CI/CD pipeline. If we had more time, we believe that would lead to higher quality releases.

![Sprint 2 Burndown Chart](images/Sprint2BurndownChart.png)

* [Sprint 2 Retrospective Video](https://youtu.be/8kk5uiaEioI)

### Daily Stand Up Meeting Recordings

* [11/18](https://youtu.be/0-hVeGmCFGY)
* [11/21](https://youtu.be/F1KQlH5aFno)
* [11/22](https://youtu.be/G1VljefEL5I)

## Building & Running

We suggest building & running the app through through a general-purpose IDE (like IntelliJ IDEA). If you're using macOS, make sure to build & run with JDK 8; newer versions may fail according to [this source](https://discourse.processing.org/t/keep-getting-noclassdeffounderror-errors-on-mac/11727).
