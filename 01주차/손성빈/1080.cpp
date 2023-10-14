#include <iostream>
using namespace std;

// 행렬 뒤집기 함수
void flipMatrix(int A[50][50], int row, int col) {
    for (int i = row; i < row + 3; i++) {
        for (int j = col; j < col + 3; j++) {
            A[i][j] = 1 - A[i][j]; // 0을 1로, 1을 0으로 뒤집음
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    int A[50][50];
    int B[50][50];

    // 행렬 A 입력
    for (int i = 0; i < n; i++) {
        string row;
        cin >> row;
        for (int j = 0; j < m; j++) {
            A[i][j] = row[j] - '0';
        }
    }

    // 행렬 B 입력
    for (int i = 0; i < n; i++) {
        string row;
        cin >> row;
        for (int j = 0; j < m; j++) {
            B[i][j] = row[j] - '0';
        }
    }

    int count = 0;

    for (int i = 0; i < n - 2; i++) {
        for (int j = 0; j < m - 2; j++) {
            if (A[i][j] != B[i][j]) {
                flipMatrix(A, i, j);
                count++;
            }
        }
    }

    // A와 B가 다르다면 A와 B를 동일하게 만들 수 없음
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (A[i][j] != B[i][j]) {
                cout << -1 << endl;
                return 0;
            }
        }
    }

    cout << count << endl;

    return 0;
}
