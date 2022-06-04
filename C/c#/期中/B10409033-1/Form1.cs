using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace B10409033_1
{
    public partial class Form1 : Form
    {

        int[,] price = { { 0,255,380,560,1095,1595,1955,2140},
                         { 45,0,345,515,1060,1560,1910,2095 },
                        { 175,140,0,345,880,1380,1740,1925},
                        { 315,280,140,0,715,1215,1565,1750},
                        { 765,730,590,450,0,670,1030,1215 },
                        {  1180,1145,1005,860,410,0,540,715},
                        { 1480,1445,1305,1160,710,295,0,355},
                        { 1630,1595,1455,1310,860,450,150,0} };
        string[] place = { "台北", "板橋", "桃園", "新竹", "台中", "嘉義", "台南", "左營" }; 
            


        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox3.Text = button1.Text;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox3.Text = button2.Text;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            textBox4.Text = button3.Text;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            textBox4.Text = button4.Text;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            try
            {
                string start = textBox1.Text;
                int start_index = 0;
                string end = textBox2.Text;
                int end_index = 0;
                string car = textBox3.Text;
                double ticket = textBox4.Text == "全票" ? 1 : 0.5;
                int num = int.Parse(textBox5.Text);
                double total = 0;
                for (int i = 0; i < place.Length; i++)
                {
                    if (start == place[i])
                    {
                        start_index = i;
                    }
                }
                for (int i = 0; i < place.Length; i++)
                {
                    if (end == place[i])
                    {
                        end_index = i;
                    }
                }
                if (start_index > end_index)
                {
                    int temp = end_index;
                    end_index = start_index;
                    start_index = temp;
                }

                if (car == "標準")
                {
                    total = price[end_index, start_index] * ticket * num;
                }
                else if (car == "商務")
                {
                    total = price[start_index, end_index] * ticket * num;
                }
                Console.WriteLine("{3},{4},{0},{1},{2}", ticket, num, total,start_index,end_index);
                MessageBox.Show(String.Format("總價:{0}", (int)total), "total");
            }
            catch
            {
                MessageBox.Show("請輸入正確資料", "Error");
            }
            

        }
    }
}
