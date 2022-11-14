using System;
using System.Collections.Generic;
namespace demo4
{
    class ForEachCapture
    {
        static void main() 
        {
            List<string> names = new List<string> {"강호동", "MC몽", "이승기"};
            var actions = new List<Action>();
            foreach (string name in names)
            {
                actions.Add(() => Console.WriteLine(name));
            }

            foreach (Action action in actions)
            {
                action();
            }
        }
        
        
    }
}