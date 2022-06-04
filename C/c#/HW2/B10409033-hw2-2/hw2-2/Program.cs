using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace hw2_2
{
    class Food
    {
        private string _id;
        private string _FoodName;
        private DateTime _dateTime;
        private double _price;


        public void SetData()
        {
            Console.WriteLine("設定產品編號");
            _id = Console.ReadLine();
            Console.WriteLine("設定產品品名");
            _FoodName = Console.ReadLine();
            Console.WriteLine("設定產品到期日(yyyymmdd)");
            _dateTime = DateTime.ParseExact(Console.ReadLine(), "yyyyMMdd", null);
            Console.WriteLine("設定產品單價");
            _price = double.Parse(Console.ReadLine());
            if(_dateTime < DateTime.Now || _price<0)
            {
                throw new FoodException();
            }
        }
    }
    class FoodException : Exception
    {
        public override string ToString()
        {
            return "\n發生Food例外類別:到期日早於現在或是單價<0";
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Food food = new Food();
            try
            {
                food.SetData();
                Console.WriteLine("設定成功");
            }
            catch (FoodException ex)
            {
                Console.WriteLine(ex.ToString());
            }
            catch (Exception ex)
            {
                Console.WriteLine("發生其他錯誤");
            }

            Console.ReadLine();

        }
    }
}
