using NUnit.Framework;
using stack;

namespace StackTest
{
    [TestFixture]
    public class StackTest
    {
        [Test]
        public void Truthyness()
        {
            var stack = new Stack();

            Assert.IsNotNull(stack);
            Assert.AreEqual(true, true);
        } 
    }
}