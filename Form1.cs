using System;
using System.Net.Http;
using System.Windows.Forms;

namespace demo4
{
    public partial class Form1 : Form
    {
        private static readonly HttpClient client = new HttpClient();
        private readonly Label label;
        private readonly Button button;

        public Form1()
        {
            InitializeComponent();
            label = new Label
            {
                Location = new System.Drawing.Point(10, 20),
                Text = "호동 뭐해!"
            };
            button = new Button
            {
                Location = new System.Drawing.Point(10, 50),
                Text = "1박 2일(유튜브)"
            };
            button.Click += DisplayWebSiteLength;
            button.AutoSize = true;
            AutoSize = true;
            Controls.Add(label);
            Controls.Add(button);
        }

        async private void DisplayWebSiteLength(object sender, EventArgs e)
        {
            label.Text = "Fetching...";
            string text = await client.GetStringAsync("https://www.youtube.com/watch?v=6URzfNRab9M&ab_channel=KBSEntertain%3A%EA%B9%94%EA%B9%94%ED%8B%B0%EB%B9%84");
            label.Text = text.Length.ToString();
        }
    }
}