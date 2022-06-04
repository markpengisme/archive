using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace B10409033_2
{
    public partial class Form1 : Form
    {
        Food[] food = new Food[50];
        int total = 0;

        class CheckException : Exception
        {
            public override String ToString()
            {

                return "請點餐後再結帳";
            }
        }
        class Food
        {
            public string type;
            public string name;
            public int price;
            public int total;
            public int sum;

           public Food(string type,string name, int price,int total,int sum)
            {
                this.type = type;
                this.name = name;
                this.price = price;
                this.total = total;
                this.sum = sum;
            }
        }
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }



        private void button11_Click(object sender, EventArgs e)
        {
            try
            {
                if (total == 0)
                    throw new CheckException() ;
                Food[,] type = new Food[4, total + 1];
                int[] type_total = new int[4];
                int sum = 0;
                for (int i = 0; i < total; i++)
                {
                    if (food[i].type == "乾麵類")
                    {
                        type[0, type_total[0]] = food[i];
                        type_total[0]++;

                    }
                    else if (food[i].type == "湯類")
                    {
                        type[1, type_total[1]] = food[i];
                        type_total[1]++;
                    }
                    else if (food[i].type == "湯麵類")
                    {
                        type[2, type_total[2]] = food[i];
                        type_total[2]++;
                    }
                    else if (food[i].type == "其他")
                    {
                        type[3, type_total[3]] = food[i];
                        type_total[3]++;
                    }
                }
                for (int i = 0; i < 4; i++)
                {
                    if (i == 0)
                        richTextBox1.Text += "乾麵類\n===========\n";
                    else if (i == 1)
                        richTextBox1.Text += "湯類\n===========\n";
                    else if (i == 2)
                        richTextBox1.Text += "湯麵類\n===========\n";
                    else
                        richTextBox1.Text += "其他\n===========\n";
                    for (int j = 0; j < type_total[i]; j++)
                    {
                        richTextBox1.Text += string.Format("{0}\t{1}\n", type[i, j].name, type[i, j].price);
                        sum += type[i, j].price;
                    }
                }
                richTextBox1.Text += string.Format("\n**************\n總數:{0}\t總金額{1}", total, sum);
            }
            catch (CheckException ex)
            {
                MessageBox.Show(ex.ToString(), "error");
            }
            catch(Exception ex)
            {
                MessageBox.Show("Error", "error");
            }

        }
        private void button1_Click(object sender, EventArgs e)
        {
            food[total] = new Food("乾麵類", "乾拌麵", 35, 1, 35);
            total++;
        }
        private void button2_Click(object sender, EventArgs e)
        {
            food[total] = new Food("乾麵類", "肉燥麵", 40, 1, 40);
            total++;
        }
        private void button6_Click(object sender, EventArgs e)
        {
            food[total] = new Food("湯類", "餛飩湯", 45, 1, 45);
            total++;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            food[total] = new Food("乾麵類", "麻醬麵", 50, 1, 50);
            total++;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            food[total] = new Food("湯麵類", "鱈魚丸麵", 70, 1, 70);
            total++;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            food[total] = new Food("湯麵類", "榨菜肉絲湯", 65, 1, 65);
            total++;
        }

        private void button7_Click(object sender, EventArgs e)
        {
            food[total] = new Food("湯類", "福州丸湯", 40, 1, 40);
            total++;
        }

        private void button8_Click(object sender, EventArgs e)
        {
            food[total] = new Food("湯類", "貢丸湯", 40, 1, 40);
            total++;
        }

        private void button9_Click(object sender, EventArgs e)
        {
            food[total] = new Food("其他", "紅油抄手", 50, 1, 50);
            total++;
        }

        private void button10_Click(object sender, EventArgs e)
        {
            food[total] = new Food("其他", "小菜", 35, 1, 35);
            total++;
        }
    }
}
