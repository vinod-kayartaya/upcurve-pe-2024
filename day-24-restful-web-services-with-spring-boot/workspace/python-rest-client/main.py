import requests
from pprint import pprint

def main():
    url = 'http://localhost:6789/api/customers'
    resp = requests.get(url, {"headers": {"Accept": "application/json"}})
    for customer in resp.json():
        print(f'{customer["id"] = }')
        print(f'{customer["name"] = }')
        print(f'{customer["city"] = }')
        print(f'{customer["email"] = }')
        print(f'{customer["phone"] = }')
        print()


if __name__ == '__main__':
    main()
