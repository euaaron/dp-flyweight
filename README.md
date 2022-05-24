# dp-flyweight

Academic task about FlyWeight pattern written in Java 11.

The project consist of a sample of the FlyWeight pattern. 
As idea, I've created a simple subscription system for students similar (not equals) to how GitHub Global Campus subscription works.

The core ideia of this pattern is to not create duplicated objects that have the same value, instead use the same.
To achieve it, a list is created to store all objects which values can be shared with other objects. 

For example:
Different Students can study at the same Campus and on the same course, so instead of adding campus and course info into the student object, we saparate them into their respective classes and create a static list to save every object created. Once a new student subscribes, we search the campus list if his campus already exists and bring the info if so. 
Otherwise we create a new Campus object and store it on the list.

