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

namespace hw2_3
{

    public partial class Form1 : Form
    {

        class IntervalException : Exception
        {
            public void ShowMsg()
            {
                MessageBox.Show("數字超過範圍", "Error");
            }
        }
        class EmptyException : Exception
        {
            public void ShowMsg()
            {
                MessageBox.Show("沒有填完", "Error");
            }
        }
        private int[] lotto = new int[7];
        private int[,] arr = new int[2, 6];
        private int[] buy = new int [2];


        public Form1()
        {
            InitializeComponent();
        }

        
        public void GetLotto()
        {
            Random r = new Random();
            for (int i = 0; i < 7; i++)
            {
                int num;
                while (true)
                {
                    num = r.Next(1, 50);
                    if (!lotto.Contains(num))
                        break;
                }
                lotto[i] = num;
            }
            FileInfo f = new FileInfo("LotteryResult.txt");
            StreamWriter sw = f.CreateText();
            sw.WriteLine(String.Format("大樂透開獎號碼:{0},{1},{2},{3},{4},{5} 特別號:{6}",
                lotto[0], lotto[1], lotto[2], lotto[3], lotto[4], lotto[5], lotto[6]));
            sw.WriteLine("========================================");
            sw.Flush();
            sw.Close();
        }
        public void EmptyAll()
        {
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
            textBox4.Text = "";
            textBox5.Text = "";
            textBox6.Text = "";
            textBox7.Text = "";
            textBox8.Text = "";
            textBox9.Text = "";
            textBox10.Text = "";
            textBox11.Text = "";
            textBox12.Text = "";
        }
        public Boolean InInterval(int num)
        {
            if (num>0 && num < 50)
            {
                return true;
            }
            return false;
        }
        public void CheckIsEmpty()
        {
            buy[0] = -1;
            buy[1] = -1;
            if(textBox1.Text == "" && 
               textBox2.Text == "" &&
               textBox3.Text == "" &&
               textBox4.Text == "" &&
               textBox5.Text == "" &&
               textBox6.Text == "")
            {
                buy[0] = 0;
            }
            if (textBox1.Text != "" &&
                textBox2.Text != "" &&
                textBox3.Text != "" &&
                textBox4.Text != "" &&
                textBox5.Text != "" &&
                textBox6.Text != "")
            {
                buy[0] = 1;
            }
            if (textBox7.Text == "" &&
                textBox8.Text == "" &&
                textBox9.Text == "" &&
                textBox10.Text == "" &&
                textBox11.Text == "" &&
                textBox12.Text == "")
            {
                buy[1] = 0;
            }
            if (textBox7.Text != "" &&
                textBox8.Text != "" &&
                textBox9.Text != "" &&
                textBox10.Text != "" &&
                textBox11.Text != "" &&
                textBox12.Text != "")
            {
                buy[1] = 1;
            }
            if(buy[0]==-1 || buy[1] == -1)
            {
                throw new EmptyException();
            }

        }
        public int[,] CheckInInterval()
        {

            if (buy[0] == 1)
            {
                arr[0, 0] = int.Parse(textBox1.Text);
                arr[0, 1] = int.Parse(textBox2.Text);
                arr[0, 2] = int.Parse(textBox3.Text);
                arr[0, 3] = int.Parse(textBox4.Text);
                arr[0, 4] = int.Parse(textBox5.Text);
                arr[0, 5] = int.Parse(textBox6.Text);
            }
            if (buy[1] == 1)
            { 
                arr[1, 0] = int.Parse(textBox7.Text);
                arr[1, 1] = int.Parse(textBox8.Text);
                arr[1, 2] = int.Parse(textBox9.Text);
                arr[1, 3] = int.Parse(textBox10.Text);
                arr[1, 4] = int.Parse(textBox11.Text);
                arr[1, 5] = int.Parse(textBox12.Text);
            }

            for(int i=0;i<2;i++)
            {
                if(buy[i]==1)
                {
                    for (int j = 0; j < 6; j++)
                    {
                        if (!InInterval(arr[i,j]))
                        {
                            throw new IntervalException();
                        }
                    }
                }           
            }
          
            return arr;
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            GetLotto();

        }
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                CheckIsEmpty();
                int[,] arr = CheckInInterval();
                FileInfo f = new FileInfo("LotteryResult.txt");
                StreamWriter sw = f.AppendText();
                sw.WriteLine("大樂透中獎情形有[]為對中" + Environment.NewLine);
                for (int i = 0; i < 2; i++)
                {
                    sw.Write(string.Format("第{0}組號碼: ", i + 1));
                    if (buy[i] == 1)
                    {

                        for (int j = 0; j < 6; j++)
                        {
                            if (lotto.Contains(arr[i, j]))
                            {
                                sw.Write(string.Format("[{0}] ", arr[i, j]));
                            }
                            else
                            {
                                sw.Write(string.Format("{0} ", arr[i, j]));
                            }
                        }
                        
                    }
                    sw.WriteLine(Environment.NewLine);
                }
                sw.WriteLine("---------------------------");
                sw.Flush();
                sw.Close();
            }
            catch(EmptyException ex)
            {
                ex.ShowMsg();
            }
            catch (IntervalException ex)
            {
                ex.ShowMsg();
            }
            catch
            {
                MessageBox.Show("輸入有錯誤重新輸入", "Error");
                EmptyAll();
            }
        }
        private void button2_Click(object sender, EventArgs e)
        {
            EmptyAll();
        }
        private void button3_Click(object sender, EventArgs e)
        {
            GetLotto();
            EmptyAll();
        }
        private void button4_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
