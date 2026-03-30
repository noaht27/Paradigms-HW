# Noah Thompson
# 30 March 2026
# issuetrack_client.py

import requests
import csv

HOST = "http://jcssdev.pythonanywhere.com/"

def main():
    # total bugs per package
    with open("total_bugs_per_package.csv", "w") as f:
        csv_writer = csv.writer(f) # this handles the fact bugs have commas in them and it wont mess up csv file
        csv_writer.writerow(["package", "total"])
        url = HOST + "bugs" # page 1
        counts = {}

        while url: # goes through each page
            # doing a get request
            response = requests.get(url)

            # getting in json like in class
            json_resp = response.json()
            url = json_resp["next"] # this is next page, it uses pagination

            # iterating through the results part of json
            for r in json_resp["results"]:
                # updating the dictionary to track counts
                if r["package"] not in counts:
                    counts[r["package"]] = 1
                else:
                    counts[r["package"]] += 1

        # writing dictionary to csv file
        for package, count in counts.items():
            csv_writer.writerow([package, count])

    # printing finished just for personal knowledge that program was successful
    print("FINISHED TOTAL BUGS PER PACKAGE!")
    
    # total comments per bug
    with open("total_comments_per_bug.csv", "w") as f:
        csv_writer = csv.writer(f)
        csv_writer.writerow(["bug_id", "total"])
        url = HOST + "comments" 
        totals = {}

        while url:
            # do a get request
            response = requests.get(url)
            json_resp = response.json()
            url = json_resp["next"]

            # go through results in json
            for r in json_resp["results"]:
                # bug_id was in "bug": "https://jcssdev.pythonanywhere.com/bugs/43814/" so by stripping 
                # the trailing / and spliting i get the last group which is the bug id i want
                bug_id = r["bug"].strip("/").split("/")[-1]

                # check if in dictionary tracker, otherwise add it
                if bug_id not in totals:
                    totals[bug_id] = 1
                else:
                    totals[bug_id] += 1

        # iterate through dictionary items writinig to the csv file
        for bug, total in totals.items():
            csv_writer.writerow([bug, total])
            
    print("FINISHED TOTAL COMMENTS PER BUG!")

if __name__ == '__main__':
    main()