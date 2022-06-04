import requests
import getpass


base_url = 'http://127.0.0.1:8000/api'

# retrieve all courses
r = requests.get(f'{base_url}/courses/')
courses = r.json()
courses.sort(key=(lambda x: x['id']))
available_courses = ', '.join(
    [f"[{course['id']}]{course['title']}" for course in courses])
print(f'Available courses: {available_courses}')

username = input("Username: ")
password = getpass.getpass("Password: ")

for course in courses:
    course_id = course['id']
    course_title = course['title']
    r = requests.post(f'{base_url}/courses/{course_id}/enroll/',
                      auth=(username, password))
    if r.status_code == 200:
        # successful request
        print(f'Successfully enrolled in {course_title}')
    else:
        r.raise_for_status()
