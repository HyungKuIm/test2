using System;
using System.Threading.Tasks;

namespace demo4
{
    class AysncEntryPoint
    {
        static async Task main()
        {
            Console.WriteLine("연극 시작전...");
            await Task.Delay(1000);
            Console.WriteLine("연극 끝난후...");
        }
    }
}