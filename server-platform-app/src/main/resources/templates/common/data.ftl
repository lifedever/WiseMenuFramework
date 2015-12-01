<#--数据有关的标签-->
<#macro pagination recordPage key="" typeId=0>
    <#if key??&& key!="">
        <#assign keyExist=true/>
    <#else>
        <#assign keyExist=false/>
    </#if>
    <#if typeId?? && typeId!=0>
        <#assign typeIdExist=true/>
    <#else>
        <#assign typeIdExist=false/>
    </#if>
    <#if recordPage?? && recordPage.totalElements gt 0>
    <nav>
        <ul class="pagination">
            <li>
                <a href="?page=${(recordPage.number<=1)?string('1', (recordPage.number-1) +'')}<#if keyExist>&key=${key}</#if><#if typeIdExist>&typeId=${typeId}</#if>"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <#list 1..recordPage.totalPages as i>
                <li><a href="?page=${i}<#if keyExist>&key=${key}</#if><#if typeIdExist>&typeId=${typeId}</#if>">${i}</a>
                </li>
            </#list>
            <li>
                <a href="?page=${((recordPage.number+ 2) <= recordPage.totalPages)?string(recordPage.number + 2,recordPage.totalPages)}<#if keyExist>&key=${key}</#if><#if typeIdExist>&typeId=${typeId}</#if>"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    </#if>
</#macro>