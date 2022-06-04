using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace hw1_2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            money1000.Enabled = false;
            money500.Enabled = false;
            money100.Enabled = false;
            money50.Enabled = false;
            money10.Enabled = false;
            money5.Enabled = false;
            money1.Enabled = false;
            changeTextBox.Enabled = false;
        }

        private void giveChangeBtn_Click(object sender, EventArgs e)
        {
            try
            {
                int buy = int.Parse(buyInput.Text);
                int pay = int.Parse(payInput.Text);
                int change = pay - buy;
                if (pay < buy)
                    MessageBox.Show("收取金額不足，請重新輸入", "Error", MessageBoxButtons.OK);
                else
                {
                    changeTextBox.Text = Convert.ToString(change);
                    money1000.Text = Convert.ToString(change / 1000) + "張";
                    money500.Text = Convert.ToString(change % 1000 /100 / 5 ) + "張";
                    money100.Text = Convert.ToString(change % 1000 /100 % 5)+ "張";
                    money50.Text = Convert.ToString(change % 100 / 10 / 5) + "個";
                    money10.Text = Convert.ToString(change % 100 / 10 % 5) + "個";
                    money5.Text = Convert.ToString(change % 10 / 5) + "個";
                    money1.Text = Convert.ToString(change % 10 % 5) + "個";
                }

            }
            catch(Exception)
            {
                MessageBox.Show("輸入錯誤無法找零", "Error", MessageBoxButtons.OK);
                money1000.Text = "";
                money500.Text = "";
                money100.Text = "";
                money50.Text = "";
                money10.Text = "";
                money5.Text = "";
                money1.Text = "";
                changeTextBox.Text = "";
            }
        }


    }
}
