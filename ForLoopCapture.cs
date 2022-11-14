using System;
using System.Collections.Generic;
namespace demo4
{
    class ForLoopCapture
    {
        static void Main()
        {
            List<string> names = new List<string> {"강호동", "MC몽", "이승기"};
            var actions = new List<Action>();
            for (int i = 0; i < names.Count; i++)
            {
                actions.Add(() => Console.WriteLine(names[i]));
            }

            foreach (Action action in actions)
            {
                action();
            }
        }
    }
}