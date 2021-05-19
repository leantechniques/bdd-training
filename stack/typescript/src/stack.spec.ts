import { Stack } from "./stack";
// UNKNOWNS
/*
* Does pushing count towards the 5 action charge?
* What other things should the stack be able to do? (isEmpty, size)
*

 */


const operations = ["PUSH", "POP", "LOCK", "DROP_IT"];

// Rule 1: Push is free
it("should not charge the user for a Push operation", () => {
  expect(Stack).toEqual(true);
  // assert that the push operation does not charge
});

// Rule 2: Pop costs 1 cent
it('should charge 1 cent for a Pop operation', () => {
  
});

// Rule 3: Every 5th operations costs 1 cent
it('should charge 1 cent every 5th operation that is not a Push', () => {
  
});

it('should not charge the user for any Push operations', () => {
  // assert that a combination of push and 4+ other operations does not charge for the push 
});

