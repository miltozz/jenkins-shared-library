# Jenkins Shared Library

- `vars` folder contains functions we call from Jenkisfile
- Each function or execution step is a separate Groovy file

3 Examples are implemented for using Jenkins Shared Library functions:

Example 1: Build, login, push, all in one block, no params provided.
- buildImageSimple() 

Example 2: Build, login, push, all in one block, with param image name.
- buildImageParams("$dockerRepoImageName")

Example 3: Extract  logic in smaller, reusable steps/functions. Using external Groovy script that we import in vars functions, with a Docker class. vars functions, return new Docker object, in which we pass the environment in a script variable, so the object has jenkins methods,envs, etc avaiable.
- buildImage "$dockerRepoImageName"
- dockerLogin()
- dockerPush "$dockerRepoImageName"

