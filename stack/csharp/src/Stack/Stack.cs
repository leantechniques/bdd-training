using System.Collections.Generic;
using System.Runtime.InteropServices.ComTypes;

namespace stack
{
    public class Stack<T>
    {
        private readonly List<T> _data = new List<T>();

        public int Count()
        {
            return _data.Count;
        }

        public Stack<T> Put(T s)
        {
            _data.Add(s);
            return this;
        }

        public T Pop()
        {
            var poppedValue = _data[GetLastIndex()];
            _data.RemoveAt(GetLastIndex());
            return poppedValue;
        }

        private int GetLastIndex()
        {
            return Count() - 1;
        }
    }
}