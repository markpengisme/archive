using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
namespace B10409033_3
{
    public partial class Form1 : Form
    {

        string[] recipes = new string[3];
        string[] bonus = new string[3];
        public Form1()
        {
            InitializeComponent();
        }
        public int CheckInvoice(String s)
        {
            int total=0;
            for(int i = 0; i < 3; i++)
            {
                if (s == recipes[i])
                {
                    total += 200000;
                }
                else if (s.Substring(1) == recipes[i].Substring(1))
                {
                    total += 40000; 
                }
                else if (s.Substring(2) == recipes[i].Substring(2))
                {
                    total += 10000;
                }
                else if (s.Substring(3) == recipes[i].Substring(3))
                {
                    total += 4000;
                }
                else if (s.Substring(4) == recipes[i].Substring(4))
                {
                    total += 1000;
                }
                else if (s.Substring(5) == recipes[i].Substring(5))
                {
                    total += 200;
                }

            }
            for (int i = 0; i < 3; i++)
            {    
                if (s.Substring(5) == bonus[i])
                {
                    total += 200;
                }

            }
            return total;
        }
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                label2.Text = recipes[0] + "\n" + recipes[1] + "\n" + recipes[2] + "\n" + bonus[0] + "\n" + bonus[1] + "\n" + bonus[2];
                string yours = textBox1.Text;
                int prize = CheckInvoice(yours);
                FileInfo f = new FileInfo("restult.txt");
                StreamWriter sw = f.AppendText();
                if (prize > 0)
                {
                    sw.WriteLine(String.Format("*{0} : NT${1}", yours, prize));

                }
                else
                {
                    sw.WriteLine(String.Format("{0} : NT${1}", yours, prize));
                }
                sw.Flush();
                sw.Close();
            }
            catch
            {
                MessageBox.Show("Error", "Error");
            }
            
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Random r = new Random();
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    recipes[i] += r.Next(1, 10).ToString();
                }
            }
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    bonus[i] += r.Next(1, 10).ToString();
                }
            }
            FileInfo f = new FileInfo("restult.txt");
            StreamWriter sw = f.CreateText();
            sw.Write("");
            sw.Flush();
            sw.Close();
        }
    }
}
