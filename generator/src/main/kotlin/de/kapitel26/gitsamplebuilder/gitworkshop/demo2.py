def fac(n):
    r = 1
    for i in range(2, n+1):
        print(i)
        r *= i
    return r

def demo():
    print("Demo")
    print(f'fac(6) = {fac(6)}')

if __name__ == '__main__':
    demo()


