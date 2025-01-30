def fac(n):
    if n == 1:
        return 1
    else:
        return n*fac(n-1)

def demo():
    print("Demo")
    print(f'fac(6) = {fac(6)}')

if __name__ == '__main__':
    demo()


