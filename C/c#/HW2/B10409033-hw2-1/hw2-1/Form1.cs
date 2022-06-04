using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.VisualBasic;

namespace hw2_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            richTextBox1.Text = "";
        }

        public string GetBMI(String h, String w)
        {
            double height = Double.Parse(h);
            double weight = Double.Parse(w);
            double bmi = weight / Math.Pow((height/100),2);
            if (bmi < 18.5 || bmi>=24)
            {
                return string.Format("{0,0:F2} (*)",bmi);
            }
            else
            {
                return string.Format("{0,0:F2}",bmi);
            }
              
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                int total = int.Parse(textBox1.Text);
                String[,] students = new String[total, 4];
                Form2 f = new Form2();
                for (int i = 0; i < total; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        switch (j)
                        {
                            case 0:
                                f.setLabel1(string.Format("請輸入學生{0}的姓名", i + 1));
                                break;
                            case 1:
                                f.setLabel1(string.Format("請輸入學生{0}的身高(cm)", i + 1));
                                break;
                            case 2:
                                f.setLabel1(string.Format("請輸入學生{0}的體重(kg)", i + 1));
                                break;
                            default:
                                break;
                        }
                        f.setTextBox1("");
                        f.ShowDialog(this);
                        students[i, j] = f.getTextBox1();
                    }
                    students[i, 3] = GetBMI(students[i, 1], students[i, 2]);
                }

                richTextBox1.Text += "姓名" + "\t" + "身高(cm)" + "\t" + "體重(kg)" + "\t" + "BMI" + "\n";
                for (int i = 0; i < total; i++)
                {
                    richTextBox1.Text += students[i, 0] + "\t" + students[i, 1] + "\t" + students[i, 2] + "\t" + students[i, 3] + "\n";
                }
            }
            catch
            {
                MessageBox.Show("error");
                Application.Exit();
            }
            

        }
    }
}
