using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace hw1_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            try
            {
                int input = int.Parse(textBox1.Text);
                if (input < 0 || input > 999999)
                {
                    // check input in 0~999999
                    MessageBox.Show("超過範圍請重新輸入(0~999999)", "Error", MessageBoxButtons.OK);
                    textBox1.Text = "";
                }
                else
                {
                    // count the number of digits is equal to 9 in input
                    int total_9 = 0;
                    while(input != 0)
                    {
                        if (input % 10 == 9)
                            total_9++;
                        input /= 10;
                        //Console.WriteLine("{0}", input); //for debug
                    }
                    MessageBox.Show("該整數中有個"+total_9+"個9", "Result", MessageBoxButtons.OK);
                }
            }
            catch(Exception)
            {
                // check overflow and text input
                MessageBox.Show("請不要亂輸入", "Error", MessageBoxButtons.OK);
                textBox1.Text = "";
            }
           
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
