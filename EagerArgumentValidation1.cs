using System;
using System.Threading.Tasks;

namespace demo4
{
    class EagerArgumentValication1
    {
        static void main()
        {
            MainAsync().GetAwaiter().GetResult();
        }

        static async Task MainAsync()
        {
            Task<int> task = ComputeLengthAsync(null);   // 1. 고의적으로 잘못된(bad) 인수를 던짐
            // Task<int> task = ComputeLengthAsync("강호동");
            Console.WriteLine("Fetched the task");
            int length = await task;   // 2. 결과를 기다림
            Console.WriteLine("Length: {0}", length);
        }

        static Task<int> ComputeLengthAsync(string text)
        {
            if (text == null)
            {
                throw new ArgumentNullException("text");  // 3. 미리 예외가 발생됨
            }
            return ComputeLengthAsyncImpl(text);
        }

        
        static async Task<int> ComputeLengthAsyncImpl(string text)
        {
            await Task.Delay(500);
            return text.Length;
        }
    }
}