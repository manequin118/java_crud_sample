# Java　0→1でCRUD処理を作成
- Viewはthymeleaf、bootstrapを使って画面を整えました。
- 画面単位のデータをFormによって受け渡しをしてます。
- Rootcontrollerにルーティングをまとめて記載してます。
- ロジック部分はServiceに記載してます。
- データベース単位のデータをEntityから受け取り、Repositoryがデータベースとのやり取りを行います。

## データベース
- MySqlを使用してます。

### 参考にした記事です
https://qiita.com/devnokiyo/items/214aa24d60764f0f55f6
