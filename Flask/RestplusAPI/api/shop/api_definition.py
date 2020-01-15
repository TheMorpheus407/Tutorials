from flask_restplus import fields
from RestplusAPI.api.myapi import api

product = api.model('Product', {
    'id': fields.Integer(readOnly=True, description='The identifier of the product'),
    'name': fields.String(required=True, description='Product name'),
})

category = api.model('Product category', {
    'id': fields.Integer(readOnly=True, description='The identifier of the category'),
    'name': fields.String(required=True, description='Category name'),
})

pagination = api.model('One page of products', {
    'page': fields.Integer(description='Current page'),
    'pages': fields.Integer(description='Total pages'),
    'items_per_page': fields.Integer(description='Items per page'),
    'total_items': fields.Integer(description='Total amount of items')
})

page_with_products = api.inherit('Page with products', pagination, {
    'items': fields.List(fields.Nested(product))
})