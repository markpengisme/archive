# Git
- 筆記（單人單分支->單人多分支)  
- 單人單分支:init,add,commit,push,pull,fetch
- branch name : i-am-a-git-repo

## 常用
- 查看目前檔案狀態 `git status`
- git的簡短紀錄 `git log --oneline`
- 更改名稱 `git mv filename new_filename`
- 還原檔案到 Repository 狀態`git checkout filename`
- 硬要pull `git fetch --all && git reset --hard origin/master`

## 分支
- 查看分支 `git branch`
- 建分支+切換 `git checkout -b <new_branch_name>`
- 刪分支 `git branch -d branch_name`
- 分枝圖 `git log --graph --oneline`
- 遠端分支上傳`git push -u origin 本地branch:遠端branch`
- 遠端分支刪除`git push -u origin :new_branch`
