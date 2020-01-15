from flask import request
from RestplusAPI.api.myapi import api
from flask_restplus import Resource
from RestplusAPI.api.shop.api_definition import page_with_products, product
from RestplusAPI.api.shop.parsers import pagination_parser as pagination
from RestplusAPI.database.dtos import Product
from RestplusAPI.api.shop.domain_logic import create_product
from flask_restplus import Namespace

from RestplusAPI.database import db as database

namespace = Namespace('shop/products/', description='Ops on my shop items')

@namespace.route('/')
class Offer(Resource):

    @api.expect(pagination)
    @api.marshal_with(page_with_products)
    def get(self):
        args = pagination.parse_args(request)
        page = args.get('page', 1)
        items_per_page = args.get('items_per_page', 10)
        products = Product.query.paginate(page, items_per_page, error_out=False)
        return products

    @api.expect(product)
    def post(self):
        create_product(request.json)
        return None, 200

@namespace.route('shop/<int:id>')
@api.response(404, 'There is no product with this ID yet.')
class ProductItem(Resource):
    def get(self, id):
        return Product.query.filter(Product.id == id).one()











