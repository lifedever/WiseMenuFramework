<#import "../tags.ftl" as tags>
<#macro main title="" css="" javascript="">
<!DOCTYPE html>
<html>
    <@tags.header.show title="${title}"/>
${css}
<body class="fixed-sidebar">
<div id="wrapper">
    <@tags.sidebar.show/>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <@tags.navTop.show />
        </div>
        <#nested>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2015
            </div>
        </div>
    </div>
</div>
<div id="globalModal" class="modal fade"></div>
    <@tags.footer.jsShow/>
${javascript}
</body>
</html>
</#macro>
