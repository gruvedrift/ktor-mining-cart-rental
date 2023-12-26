<#-- @ftlvariable name="order" type="com.gruvedrift.models.Order" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${order.id}
        </h3>
        <p>
            ${order.orderingCustomer}
        </p>
        <p>
            ${order.carts}
        </p>
        <hr>
        <p>
            <a href="/order/${order.id}/edit">Edit order</a>
        </p>
    </div>
</@layout.header>
