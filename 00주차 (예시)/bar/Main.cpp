#include <iostream>

using namespace std;

void testcase()
{
    int A, B;

    std::cin >> A >> B;
    std::cout << A + B;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    setbuf(stdout, NULL);

    testcase();
    return 0;
}