###Setup instructions for cloning this repository in Ellipse using Git
+ [download git](https://github.com/bbachmey/GitHow/blob/master/download.md)  
+ [install git](https://github.com/bbachmey/GitHow/blob/master/install_git.md)  
+ go to workspace
```
cd v:\workspace
```
+ initialize repository
```
git init
```
+ add remote origin
```
git remote add origin https://github.com/bbachmey/OST.git
```
+ verify remote
```
git remote -v
# origin  https://github.com/bbachmey/OST.git (fetch)
# origin  https://github.com/bbachmey/OST.git (push)
```
+ fetch remote
```
git fetch origin
```
+ merge remote
```
git merge origin/branchname
```

Reference:  
https://help.github.com/articles/adding-a-remote  
https://help.github.com/articles/fetching-a-remote  

### After changes have been made on another machine and pushed to GitHub

1. [fetch and merge](https://github.com/bbachmey/GitHow/blob/master/fetch_and_merge.md)
2. file > import
3. existing projects into workspace
4. select root directory: v:\workspace
5. finish
