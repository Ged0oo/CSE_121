#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

#include <iostream>
using namespace std;



class ICalculator 
{
    public:
        virtual int add(int x, int y) = 0;
        virtual double div(int x, int y) = 0;
};


class MyClass : public ICalculator 
{
    public:
    
        int add(int x, int y) override 
        {
            return x + y;
        }

        double div(int x, int y) override 
        {
            if (y == 0) {
                cout << "Error" << endl;
                return 0.0;
            }
            return static_cast<double>(x) / y;
    }
};
int main() 
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
    MyClass calculator;
    int x, y;
    char ch;
    
    cin >> x;
    cin >> ch;
    cin >> y;
    
    switch (ch) 
    {
        case '+': 
            cout << calculator.add(x, y) << endl; 
            break;
            
        case '/': 
            if(y != 0)
            {
                cout << calculator.div(x, y) << endl; 
            }
            else 
            {
                cout << "Error" << endl; 
            }
            break;
        default: 
            cout << "Error" << endl; 
            break;
    }
    return 0;
}