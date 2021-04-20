# football-league-ps-microservice
Microservices - to fetch football league team standings from football api


Develop, Test and Deploy a microservice to find standings of a team playing league football match using country name, league name and team name. The
service should be accessible via web browser on internet and end user should be able to view results by changing previously listed parameters. Output of
this service should be presented in web browser using any one of Javascript framework, HTML or JSON. And the service should be ready to be released
to production or live environment. In output, display following:   

`Country ID & Name: (<ID>) - <name>  ` 
`League ID & Name: (<ID>) - <name> ` 
`Team ID & Name: (<ID>) - <name>  `
`Overall League Position: <position>  `

http url: `http://localhost:8085/api/service/v1/team/standing?teamName=Leeds&countryName=England&leagueName=Championship`

output: 
`{
"country": "(41) - England",
"league": "(149) - Championship",
"team": "(2653) - Leeds",
"overallPosition": 1
}`

Test cases yet to write