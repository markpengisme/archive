using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace hw2_1
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        public string getTextBox1()
        {
            return textBox1.Text;
        }
        public void setTextBox1(string s)
        {
            textBox1.Text = s;
        }
        public void  setLabel1(string s)
        {
            label1.Text = s;
        }
    }
}
