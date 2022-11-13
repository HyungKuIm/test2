using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;

namespace demo4
{
    class AwaitingFailedOperations
    {
        static void main()
        {
            var task = FetchFirstSuccessfulAsync(new[] {
                "https://my.youtube.com", "https://youtube.com", "https://microsoft.com", "https://apple.com"
            });
            var result = task.GetAwaiter().GetResult();
            //var result = task.Result;
            Console.WriteLine(result.Length);
            //Console.WriteLine(result);
        }

        static async Task<string> FetchFirstSuccessfulAsync(IEnumerable<string> urls)
        {
            var client = new HttpClient();
            foreach (string url in urls)
            {
                try
                {
                    return await client.GetStringAsync(url);
                }
                catch (HttpRequestException exception) 
                {
                    Console.WriteLine("Faile to fetch {0}: {1}", url, exception.Message);
                }
            }
            throw new HttpRequestException("No URLs succeeded");
        }
    }
}