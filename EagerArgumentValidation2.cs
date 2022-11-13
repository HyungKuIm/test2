using System;
using System.Threading.Tasks;

namespace demo4
{
    class EagerArgumentValication2
    {
        static void main()
        {
            MainAsync().GetAwaiter().GetResult();
        }

        static async Task MainAsync()
        {
            // Task<int> task = ComputeLengthAsync(null);
            Task<int> task = ComputeLengthAsync("강호동");
            Console.WriteLine("Fetched the task");
            int length = await task;
            Console.WriteLine("Length: {0}", length);
        }

        static Task<int> ComputeLengthAsync(string text)
        {
            if (text == null)
            {
                throw new ArgumentNullException("text");
            }

            // 단지 Func<Task<int>>를 사용할 수 있었지만, 값을 직접적으로 던지는 것보다
            //  비효율적이라고 할 수 있음(클로저가 됨)
            Func<string, Task<int>> impl = async t =>
            {
                await Task.Delay(500);
                return t.Length;
            };
            
            return impl(text);
        }

        
    }
}