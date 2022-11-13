using System;
using System.Threading.Tasks;

namespace demo4
{
    class EagerArgumentValication3
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
                // nameof를 사용하여 우연한 타이핑 실수를 방지할 수 있다.
                throw new ArgumentNullException(nameof(text));
            }
            return Impl(text);

            // 파라미터가 없는 메소드를 사용할 수도 있지만, 이렇게 던짐으로
            // 캡처링을 피함으로, 컴파일러가 보다 더 최적화 할수 있음
            async Task<int> Impl(string t)
            {
                await Task.Delay(500);
                return t.Length;
            }
        }

        
    }
}