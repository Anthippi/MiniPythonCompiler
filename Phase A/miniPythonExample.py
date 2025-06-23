# Example miniPython program

def factorial(n):
    result = 1
    while n > 1:
        result = result * n
        n = n - 1
    return result

x = 5
y = factorial(x)

if y > 100:
    print("Large factorial")
else:
    print("Small factorial")
