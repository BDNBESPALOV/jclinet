<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome freemarker</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>

<body>
<h1>Welcome freemarker</h1>
<#if message??>
<h2>${message}</h2>
</#if>


<div>
    <fieldset>
        <legend>Command console</legend>
        <form name="person" action="" method="POST">
            Command: <@spring.formInput "jClient.command" "" "text"/>    <br/>
            <input type="submit" value="Create" />
        </form>
    </fieldset>
</div>

</body>

</html>