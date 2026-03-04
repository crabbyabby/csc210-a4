# A4 DIY Calculator

Your readme should include the following information. Each student needs to submit their own reflection, even when pair programming.  Please write N/A if an item does not apply.

## Basic Information

Your Name: Abigail Lei

Other collaborators you worked with, including TAs (and feel free to give a shoutout to anyone who was particularly helpful): Claire, shoutout Esther and Emily for giving me the motivation to turn in my first assignment ON TIME!

Any references used besides JavaDoc and course materials:
https://stackoverflow.com/questions/7503877/java-correct-way-convert-cast-object-to-double 
## Questions for You

Which backing structure did you choose for your Stack/Queue (SLL or DynamicArray), and why? 

I chose to use a SLL mainly because I would not have to resize the backing array. It also made much more sense to me mainly because I chose to track the tail.

What is the runtime cost of each primary operation (push/pop/peek for Stack; enqueue/dequeue/peek for Queue) with your choice?
Because I chose to track the tail, all runtimes are O(1). Since access for the stack is from one end, pushing, popping, and peeking from the head allows the implementation to be O(1). For queue, I added from the tail and popped from the head so that it would remain O(1).

## Reflection

Reflection on your experience with this assignment: I liked this assignment, especially creating the stacks and queues implementations. Felt nice to not turn something in 3 days late which made the experience more enjoyable.

