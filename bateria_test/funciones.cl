void sub_test()
{
    print_ln("Hello again");
}

void test()
{
    print_ln("Hello");
    sub_test();
}

int sum(int a, int b)
{
    return a + b;
}

void swap(int &a, int &b)
{
    int c;
    c = a;
    a = b;
    b = c;
}

void swap_by_swap(int &a, int &b)
{
    swap(a, b);
}

void swap_char(char &a, char &b)
{
    char c;
    c = a;
    a = b;
    b = c;
}

void set_all_ref(int& arr[5])
{
    arr[0] = -1;
    arr[1] = -2;
    arr[2] = -3;
    arr[3] = -4;
    arr[4] = -5;
}

void show_all_ref(int& arr[5])
{
    // print_ln(arr[0]);
    int i;
    i = 0;

    while (i < 5) {
        print_ln(arr[i]);
        i = i + 1;
    }
}

int sum_all(int arr[5])
{
    int i, sum;
    i = 0;
    sum = 0;

    while (i < 5) {
        sum = sum + arr[i];
        i = i + 1;
    }

    return sum;
}

void main()
{
    int a, b ,c;
    int arr[5];
    char cad[2];
    char l;

    // Basic calls
    test();

    a = 2;
    b = 3;
    // Value call
    c = sum(a, b);
    print_ln(a, " ", b, " ", c);

    arr[0] = 10;
    arr[1] = 5;
    // Value call with array element
    arr[2] = sum(arr[0], arr[1]);
    print_ln(arr[0], " ", arr[1], " ", arr[2]);

    a = 0;
    b = 1;
    print_ln(a, " ", b);
    // Reference call
    swap(a, b);
    print_ln(a, " ", b);
    // Reference by reference call
    swap_by_swap(a, b);
    print_ln(a, " ", b);

    cad[0] = 'a';
    cad[1] = 'b';
    print_ln(cad[0], " ", cad[1]);
    // Reference call with array element
    swap_char(cad[0], cad[1]);
    print_ln(cad[0], " ", cad[1]);

    // Reference call with array
    set_all_ref(arr);
    show_all_ref(arr);
    // Value call with array
    print_ln(sum_all(arr));
}
