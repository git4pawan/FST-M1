# create a dictionary
fruit_dict = {
    "apple": 10,
    "mango": 50,
    "grapes": 40,
    "orange": 40
}
key_to_check = input("What are you looking for? ").lower()

if (key_to_check in fruit_dict):
    print("Yes ! It's available")
else:
    print("No ! It's not available")