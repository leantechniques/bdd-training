using System;
using NUnit.Framework;
using stack;

namespace StackTest
{
    [TestFixture]
    public class StackTest
    {
        private Stack<string> _stack;

        [SetUp]
        public void Setup()
        {
            _stack = new Stack<string>();
        }

        [Test]
        public void NewStackIsEmpty()
        {
            Assert.AreEqual(0, _stack.Count());
        }

        [Test]
        public void PutIncreasesCountByOne()
        {
            Assert.AreEqual(1, _stack.Put("a").Count());
        }

        [Test]
        public void PopReturnsLastItemAdded()
        {
            Assert.AreEqual("z", _stack.Put("a").Put("z").Pop());
            Assert.AreEqual("a", _stack.Pop());
        }

        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void PopEmptyStackThrowsException()
        {
            _stack.Pop();
        }
    }
}