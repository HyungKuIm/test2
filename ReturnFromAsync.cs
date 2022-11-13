using System;
using System.Net.Http;
using System.Threading.Tasks;

namespace demo4
{
    class ReturnFromAsync
    {
        static readonly HttpClient client = new HttpClient();

        static async Task<int> GetPageLengthAsync(string url)
        {
            Task<string> fetchTextTask = client.GetStringAsync(url);
            int length = (await fetchTextTask).Length;
            return length;
        }

        static void PrintPageLength()
        {
            Task<int> lengthTask = 
                GetPageLengthAsync("https://www.youtube.com/watch?v=6URzfNRab9M&ab_channel=KBSEntertain%3A%EA%B9%94%EA%B9%94%ED%8B%B0%EB%B9%84");
            Console.WriteLine(lengthTask.Result);
        }

        static void main()
        {
            PrintPageLength();
        }
    }
}